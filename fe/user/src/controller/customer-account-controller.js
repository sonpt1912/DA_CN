window.customerController = function ($scope, $http) {
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
};
