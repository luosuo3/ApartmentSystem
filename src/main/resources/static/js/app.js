
$(function() {
    
    $('.prev-slide').on('click', function() {
        $('#slideshow').carousel('prev');
    });

    $('.next-slide').on('click', function() {
        $('#slideshow').carousel('next');
    });
    
    $(document).on('keydown', function(e) {
        console.log(e.which);
        switch (e.which) {
            case 37:
                $('#slideshow').carousel('prev');
                break;
            case 39:
                $('#slideshow').carousel('next');
                break;
        }
    });
            var picker1 = $('#datetimepicker1').datetimepicker({

            format: 'YYYY-MM-DD',

            locale: moment.locale('zh-cn'),

            //minDate: '2016-7-1'

        });

        var picker2 = $('#datetimepicker2').datetimepicker({

            format: 'YYYY-MM-DD',

            locale: moment.locale('zh-cn')

        });

        //动态设置最小值

        picker1.on('dp.change', function (e) {

            picker2.data('DateTimePicker').minDate(e.date);

        });

        //动态设置最大值

        picker2.on('dp.change', function (e) {

            picker1.data('DateTimePicker').maxDate(e.date);

        });

    var play = false;
    $('.play-and-stop').click(
        function() {
            if (!play) {
                $('#slideshow').carousel('cycle');
                $(this).children('span').removeClass('glyphicon-play').addClass('glyphicon-pause');
            } else {
                $('#slideshow').carousel('pause');
                $(this).children('span').removeClass('glyphicon-pause').addClass('glyphicon-play');                
            }
            play = !play;
        }
    );
        
});
