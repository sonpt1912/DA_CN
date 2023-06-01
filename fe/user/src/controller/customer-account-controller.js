window.customerController = function ($scope, $http) {
  // form address
  $scope.formAddress = {
    idCustomer: 1,
    city: "",
    district: "",
    ward: "",
    description: "",
  };

  // form
  $scope.formCustomer = {
    idCustomer: 1,
    lastName: "",
    firstName: "",
    phoneNumber: "",
    email: "",
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

  // get customer
  $scope.getInfor = function () {
    $http.get(customerAPI + "/get-one-by-id/" + 1).then(function (response) {
      $scope.formCustomer.lastName = response.data.lastName;
      $scope.formCustomer.firstName = response.data.firstName;
      $scope.formCustomer.phoneNumber = response.data.phoneNumber;
      $scope.formCustomer.email = response.data.email;
    }),
      function (error) {
        console.log(error);
      };
  };

  // hàm update infor
  $scope.editInfor = function () {
    console.log($scope.formCustomer);
    $http
      .put(customerAPI + "/update", $scope.formCustomer)
      .then(function (response) {});
  };

  // hàm add new address
  $scope.addAdress = function () {
    $scope.formAddress.city = JSON.parse($scope.selectedProvinceId).name;
    $scope.formAddress.district = JSON.parse($scope.selectedDistrictId).name;
    $scope.formAddress.ward = JSON.parse($scope.selectedWardId).name;
    $scope.formAddress.description = $scope.description;
    console.log(JSON.parse(JSON.stringify($scope.formAddress)));
    $http
      .post(addressAPI + "/add-address", JSON.stringify($scope.formAddress))
      .then(function (response) {});
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
