window.checkoutUserController = function ($scope, $http, $routeParams) {
  $scope.idCart = $routeParams.id;
  $scope.totalPrice = 0;

  // form address
  $scope.formAddress = {
    idCustomer: 1,
    city: "",
    district: "",
    ward: "",
    description: "",
  };

  // formBill
  $scope.formBill = {
    idCart: $scope.idCart,
    codeVoucher: "",
    idCustomer: 1,
    address: "",
    description: "",
  };

  // Lấy detail cart
  $scope.listDetailCarts = [];
  $http
    .get(detailCart + "/get-by-cart/" + $scope.idCart)
    .then(function (response) {
      $scope.listDetailCarts = response.data;
      $scope.calculateTotalPrice();
      $scope.id = response.data.idDetailProduct;
    }),
    function (error) {
      console.log(error);
    };

  // lấy all address
  $scope.listAddress = [];
  $http
    .get(addressAPI + "/get-all-address-by-customer/" + 1)
    .then(function (response) {
      $scope.listAddress = response.data;
      $scope.getAddress($scope.listAddress[0].idAddress);
    }),
    function (error) {
      console.log(error);
    };

  // lấy address

  $scope.getAddress = function (idAddress) {
    $scope.address = [];
    $http.get(addressAPI + "/get-by-id/" + idAddress).then(function (response) {
      $scope.address = response.data;
      $scope.formBill.address =
        $scope.address.description +
        ", " +
        $scope.address.ward +
        ", " +
        $scope.address.district +
        ", " +
        $scope.address.city;
    }),
      function (error) {
        console.log(error);
      };
  };

  //
  // lấy user hiện tại
  $scope.customer = [];
  $http.get(customerAPI + "/get-one-by-id/" + 1).then(function (response) {
    $scope.customer = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // lấy số tiền của voucher
  $scope.code = "";
  $scope.discountPrice = 0;
  $scope.getVoucher = function () {
    $http
      .get(voucherAPI + "/get-voucher-by-code/" + $scope.code)
      .then(function (response) {
        $scope.discountPrice = response.data;
        return true;
      }),
      function (e) {
        console.log(e);
      };
    return false;
  };

  // hàm add address
  $scope.addAdress = function () {
    $http
      .post(addressAPI + "/add-address", $scope.formAddress)
      .then(function (response) {});
  };

  // add bill
  $scope.addBill = function () {
    swal({
      title: "Are you sure?",
      text: "buy this product",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    }).then((willDelete) => {
      if (willDelete) {
        $scope.formBill.description = $scope.description;
        if ($scope.discountPrice.discountAmount > 0) {
          $scope.formBill.codeVoucher = $scope.code;
        } else {
          $scope.formBill.codeVoucher = null;
        }

        $http
          .post(billAPI + "/add-to-bill", $scope.formBill)
          .then(function (response) {});
        window.location.href = "#customer-account";
        swal("Poof! Succes", {
          icon: "success",
        });
      } else {
        swal("Cancel");
      }
    });
  };

  //tính thuế tax
  $scope.calculateTax = function () {
    var taxRate = 0.1; // Tỷ lệ thuế là 10%
    var tax = $scope.totalPrice * taxRate;
    return tax;
  };

  // tổng tiền sau thuế
  $scope.calculateToTal = function () {
    var total = $scope.totalPrice + $scope.calculateTax();
    if ($scope.discountPrice != 0) {
      return total - $scope.discountPrice.discountAmount;
    }
    return total;
  };

  // tính tổng tiền của sản phẩm
  $scope.calculateTotalPrice = function () {
    $scope.totalPrice = 0;
    for (var i = 0; i < $scope.listDetailCarts.length; i++) {
      var detailCart = $scope.listDetailCarts[i];
      var price = detailCart.price;
      var quantity = detailCart.quantity;
      $scope.totalPrice += price * quantity;
    }
  };

  $scope.Provinces = []; // Cập nhật dữ liệu về tỉnh/thành phố từ JSON
  $scope.Districts = []; // Cập nhật dữ liệu về quận/huyện từ JSON
  $scope.Ward = []; // Cập nhật dữ liệu về quận/huyện từ JSON

  // lấy thành phố
  $http
    .get("https://vn-public-apis.fpo.vn/provinces/getAll?limit=-1")
    .then(function (response) {
      $scope.Provinces = response.data.data.data;
    });

  // Sự kiện khi chọn một tỉnh/thành phố
  $scope.onProvinceChange = function () {
    var selectedProvinceId = $scope.selectedProvinceId; // Lấy ID của tỉnh/thành phố đã chọn
    $http
      .get(
        "https://vn-public-apis.fpo.vn/districts/getByProvince?provinceCode=" +
          selectedProvinceId +
          "&limit=-1"
      )
      .then(function (response) {
        $scope.Districts = response.data.data.data;
      });
  };

  // Sự kiện khi chọn một huyện
  $scope.onDistrictChange = function () {
    var selectedDistrictId = $scope.selectedDistrictId; // Lấy ID của tỉnh/thành phố đã chọn
    $http
      .get(
        "https://vn-public-apis.fpo.vn/wards/getByDistrict?districtCode=" +
          selectedDistrictId +
          "&limit=-1"
      )
      .then(function (response) {
        $scope.Ward = response.data.data.data;
      });
  };

  // button toast
  var showToastCheckbox = document.getElementById("showToast");
  var toastContainer = document.querySelector(".toast-container");
  var liveToast = document.getElementById("liveToast");
  var addToat = document.getElementById("addToat");
  var toastBody = document.getElementById("toastBody");

  showToastCheckbox.addEventListener("click", function () {
    $scope.getVoucher();
    if ($scope.discountPrice > 0) {
      showToast("add voucher successfully");
    } else {
      showToast("add voucher failure");
    }
  });

  function showToast(message) {
    var clonedToast = liveToast.cloneNode(true);
    var clonedToastBody = clonedToast.querySelector(".toast-body");
    clonedToastBody.textContent = message;
    toastContainer.appendChild(clonedToast);
    var newToast = new bootstrap.Toast(clonedToast);
    newToast.show();
  }
};
