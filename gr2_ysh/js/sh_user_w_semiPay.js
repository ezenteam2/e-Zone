
var block = $('.block').get();
var none = $('.none').get();
var first = $('#first').get();
for(let i = 0; i<block.length; i++){
    $(block[i]).css('display','none');
    $(none[i]).css('display','block');
    console.log(block[i])
    $(none[i]).click(function(e){
        $(none[i]).css('display','none');
        $(block[i]).css('display','block');
        $(first[i]).trigger('click');
    })
    $(block[i]).click(function(e){
        $(block[i]).css('display','none');
        $(none[i]).css('display','block');
        $(first[i]).trigger('click');
    })
}

