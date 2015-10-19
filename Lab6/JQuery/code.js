// EFFECT
function simpleEffect(){
    $('#slidetoggle').slideToggle();
    window.setTimeout(simpleEffect(), 3000);
}

$(document).ready(function(){

    // EVENT & 5 DIFFERENT CSS
    $('#thisDiv').click(function(){
        // Time to change 5 of the css values!
        $(this).css('background-color', 'red')
            .css('color', 'white')
            .css('border', "1px solid black")
            .css('font-size', "23px")
            .css('opacity',.4);
        $('#explainDiv').text('Looky! It changed! We changed the background-color, color, border, font-size, and opacity');

    });

    // EVENT & EFFECT
    $('#hoverOverMe').hover(function(){
        $( this ).animate({
            opacity: 0.4,
            marginLeft: "0.6in",
            fontSize: "3em",
            borderWidth: "10px"
        }, 800 );
    });

    // EVENT AND EFFECT
    $('#mouseLeaveMe').mouseleave(function(){
        $( this).fadeOut(2000);
    });

    // EVENT AND EFFECT
    $('#focusOnMe').focus(function(){
        $( this).slideUp(2000);
    });

    // EVENT AND EFFECT
    $('#keydownOnMe').keydown(function(){
        $('#hiddenSpan').fadeIn(2000);
    });

    simpleEffect();
});