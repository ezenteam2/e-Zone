
var block = $('.block').get();
var none = $('.none').get();
var first = $('#first').get();

for(let i = 0; i<block.length; i++){
    $(block[i]).css('display','none');
    $(none[i]).css('display','block');
    
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

var all__block = $('.all__block');
var all__none = $('.all__none');
var all = $('#all');

all__none.css('display','block');
all__block.css('display','none');

all__none.click(function(e){
    all__block.css('display','block');
    all__none.css('display','none');
    all.trigger('click');
    $(block).css('display','block');
    $(none).css('display','none');
})
all__block.click(function(e){
    all__block.css('display','none');
    all__none.css('display','block');
    all.trigger('click');
    $(block).css('display','none');
    $(none).css('display','block');
})
