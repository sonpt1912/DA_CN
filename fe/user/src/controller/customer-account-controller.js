window.customerController = function ($scope, $http) {
  // form address
  $scope.formAddress = {
    idCustomer: 1,
    nameProvice: "",
    nameDistrict: "",
    nameWard: "",
    description: "",
  };

  // cart
  $scope.IdCart = [];
  $http.get(cartAPI + "/get-cart-by-customer/" + 1).then(function (response) {
    $scope.IdCart = response.data;
  });

  // lấy all address
  $scope.listAddress = [];
  $http
    .get(addressAPI + "/get-all-address-by-customer/" + 1)
    .then(function (response) {
      $scope.listAddress = response.data;
    }),
    function (error) {
      console.log(error);
    };

  // xóa address
  $scope.deleteAddress = function (addressId) {
    $http
      .delete(addressAPI + "/delete/" + addressId)
      .then(function (response) {});
  };

  // lấy customer
  $scope.customer = [];
  $http.get(customerAPI + "/get-one-by-id/" + 1).then(function (response) {
    $scope.customer = response.data;
  }),
    function (error) {
      console.log(error);
    };

  // hàm add new address
  $scope.addAdress = function () {
    // $scope.formAddress.nameProvice = JSON.parse($scope.selectedProvinceId).name;
    // $scope.formAddress.nameDistrict = JSON.parse(
    //   $scope.selectedDistrictId
    // ).name;
    // $scope.formAddress.nameWard = JSON.parse($scope.selectedWardId).name;
    // $scope.formAddress.description = $scope.description;
    // console.log(JSON.stringify($scope.formAddress));
    // $http
    //   .post(addressAPI + "/add-address", JSON.stringify($scope.formAddress))
    //   .then(function (response) {});
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
    let code = JSON.parse(selectedProvinceId).code;
    $http
      .get(
        "https://vn-public-apis.fpo.vn/districts/getByProvince?provinceCode=" +
          code +
          "&limit=-1"
      )
      .then(function (response) {
        $scope.Districts = response.data.data.data;
      });
  };

  // Sự kiện khi chọn một huyện
  $scope.onDistrictChange = function () {
    var selectedDistrictId = $scope.selectedDistrictId; // Lấy ID của tỉnh/thành phố đã chọn
    let code = JSON.parse(selectedDistrictId).code;
    $http
      .get(
        "https://vn-public-apis.fpo.vn/wards/getByDistrict?districtCode=" +
          code +
          "&limit=-1"
      )
      .then(function (response) {
        $scope.Ward = response.data.data.data;
      });
  };
};
