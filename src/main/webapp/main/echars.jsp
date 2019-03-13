<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main1" style="width: 1000px;height:580px;"></div>
    <script type="text/javascript">
        $(function(){
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main1'));
            
            
            var goEasy = new GoEasy({
        		appkey: 'BC-5edd6bf3c3ff4f78846ad2c1b74988d7'
        		});	
        	
        	
        	
            
            $.post("${pageContext.request.contextPath}/user/echars.do",function(data){
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '2018年每月注册人数统计'
                    },
                    tooltip: {},
                    legend: {
                        data:['男','女'],
                    },
                    
                    xAxis: {
                        data: data.months
                    },
                    yAxis: {},
                    series: [{
                        name: '男',
                        type: 'bar',
                        data: data.man,
                    },{
                        name: '女',
                        type: 'bar',
                        data: data.woman
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            },"json");
            
            
            goEasy.subscribe({
        		channel:'demo_channel',
        		onMessage: function(message){
        			var data = JSON.parse(message.content); 
        			// 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '2018年每月注册人数统计'
                        },
                        tooltip: {},
                        legend: {
                            data:['男','女'],
                        },
                        xAxis: {
                            data: data.months
                        },
                        yAxis: {},
                        series: [{
                            name: '男',
                            type: 'bar',
                            data: data.man
                        },{
                            name: '女',
                            type: 'bar',
                            data: data.woman
                        }]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
        		}
        	});
            
            

        });
    </script>