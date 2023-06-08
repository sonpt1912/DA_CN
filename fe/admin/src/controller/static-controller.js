window.staticController = function ($http, $scope) {
  // total money this month
  $scope.thisMonth = 0;
  $http.get(billAPI + "/total-this-month").then(function (response) {
    $scope.thisMonth = response.data;
  });

  $scope.thisYear = 0;
  $http.get(billAPI + "/total-this-year").then(function (response) {
    $scope.thisYear = response.data;
  });

  $scope.totalProduct = 0;
  $http.get(billAPI + "/total-product-this-year").then(function (response) {
    $scope.totalProduct = response.data;
  });

  // get list of year
  var result = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  $http.get(billAPI + "/area-chart").then(function (response) {
    $scope.areaChartData = response.data;

    for (let i = 0; i < response.data.length; i++) {
      let month = response.data[i].month;
      let totalMoney = response.data[i].totalMoney;
      result[month - 1] = totalMoney;
    }

    // Call the areaChart function to draw the chart
    drawAreaChart();
  });

  // area chart
  function drawAreaChart() {
    var ctx = document.getElementById("myAreaChart").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "line",
      data: {
        labels: [
          "January",
          "February",
          "March",
          "April",
          "May",
          "June",
          "July",
          "August",
          "September",
          "October",
          "November",
          "December",
        ],
        datasets: [
          {
            label: "Earnings",
            data: result,
            backgroundColor: "rgba(78, 115, 223, 0.05)",
            borderColor: "rgba(78, 115, 223, 1)",
            pointRadius: 3,
            pointBackgroundColor: "rgba(78, 115, 223, 1)",
            pointBorderColor: "rgba(78, 115, 223, 1)",
            pointHoverRadius: 3,
            pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
            pointHoverBorderColor: "rgba(78, 115, 223, 1)",
            pointHitRadius: 10,
            pointBorderWidth: 2,
          },
        ],
      },
      options: {
        maintainAspectRatio: false,
        responsive: true,
        scales: {
          x: {
            grid: {
              display: false,
            },
          },
          y: {
            grid: {
              borderDash: [2],
              color: "rgba(0, 0, 0, .1)",
              zeroLineColor: "rgba(0, 0, 0, .1)",
            },
          },
        },
        plugins: {
          legend: {
            display: false,
          },
        },
      },
    });
  }

  $scope.pieChart = function () {
    var ctx = document.getElementById("myPieChart").getContext("2d");
    var myChart = new Chart(ctx, {
      type: "pie",
      data: {
        labels: ["Direct", "Referral", "Social"],
        datasets: [
          {
            data: [55, 30, 15],
            backgroundColor: ["#4e73df", "#1cc88a", "#36b9cc"],
            hoverBackgroundColor: ["#2e59d9", "#17a673", "#2c9faf"],
            hoverBorderColor: "rgba(234, 236, 244, 1)",
          },
        ],
      },
      options: {
        responsive: true,
        tooltips: {
          backgroundColor: "rgb(255,255,255)",
          bodyFontColor: "#858796",
          borderColor: "#dddfeb",
          borderWidth: 1,
          xPadding: 15,
          yPadding: 15,
          displayColors: false,
          caretPadding: 10,
        },
        legend: {
          display: true,
          position: "bottom",
          labels: {
            fontColor: "#858796",
          },
        },
      },
    });
  };

  // Call the pieChart
  $scope.pieChart();
};
