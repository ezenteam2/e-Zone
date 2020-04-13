$('.block').css('display','none');
$('.none').css('display','block');

$('.none').click(function(e){
    $('.none').css('display','none');
    $('.block').css('display','block');
    $('#first').trigger('click');
})
$('.block').click(function(e){
    $('.block').css('display','none');
    $('.none').css('display','block');
    $('#first').trigger('click');
})

    
