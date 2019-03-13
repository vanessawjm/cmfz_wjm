<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 1000px;height:580px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        var goEasy = new GoEasy({
    		appkey: 'BC-5edd6bf3c3ff4f78846ad2c1b74988d7'
    		});	
    	
        
        // 指定图表的配置项和数据
        option = {
            title : {
                text: '各地区人员分布',
                subtext: '持名法洲',
                left: 'center'
            },
            tooltip : {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data:['男','女']
            },
            visualMap: {
                min: 0,
                max: 500,
                left: 'left',
                top: 'bottom',
                text:['高','低'],           // 文本，默认为数值文本
                calculable : true
            },
            toolbox: {
                show: true,
                orient : 'vertical',
                left: 'right',
                top: 'center',
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            series : [{
                    name: '男',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    label: {
                        normal: {
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:[]
                },{
                    name: '女',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                        normal: {
                            show: false
                        },
                        emphasis: {
                            show: true
                        }
                    },
                    data:[]
                }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        $.getJSON(
            "${pageContext.request.contextPath}/user/male.do",
            function (data) {
                myChart.setOption({
                    series : [{
                        name: '男',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data
                    }]
                });
            }
        );
        goEasy.subscribe({
    		channel:'demo_channe2',
    		onMessage: function(message){
    			var data = JSON.parse(message.content); 
    			myChart.setOption({
                    series : [{
                        name: '女',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data
                    }]
                });
                
    		}
    	});
              
        $.getJSON(
            "${pageContext.request.contextPath}/user/female.do",
            function (data) {
               
                myChart.setOption({
                    series : [{
                        name: '女',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data
                    }]
                });
            }
        );
        
        goEasy.subscribe({
    		channel:'demo_channe3',
    		onMessage: function(message){
    			var data = JSON.parse(message.content); 
    			 myChart.setOption({
                     series : [{
                         name: '男',
                         type: 'map',
                         mapType: 'china',
                         roam: false,
                         label: {
                             normal: {
                                 show: false
                             },
                             emphasis: {
                                 show: true
                             }
                         },
                         data:data
                     }]
                 });
                
    		}
    	});

        
        
        
        
    </script>