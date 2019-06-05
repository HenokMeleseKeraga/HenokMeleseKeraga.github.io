"use strict";

var currentAnimation; // an array of frames, the first element should be displayed next.
var interval; // an interval object.
const speed = 250; // interval delay for the animation, initially set to normal.
var size; // font size of the output, initially set to medium by the css file.

window.onload = pageLoad;
// sets up event handlers for all the controls
function pageLoad() {
    document.getElementById("stop").disabled = true;
    document.getElementById("start").onclick = play;
    document.getElementById("stop").onclick = stop;
    document.getElementById("animation").onchange = changeAnimation;
    document.getElementById("txtsize").onchange = changeSize;

    var radio = document.getElementById("ckbox");
    radio.onclick = (function (currentSpeed) { // update the speed, keep displaying frames during an animation
       
        return function () {
            document.getElementById("ckbox").value="250";
            speed = currentSpeed;
           // if (interval) {
                clearInterval(interval);
          //  }
            if (document.getElementById("start").disabled) {
                interval = setInterval(function () { displayNextFrame(currentAnimation); }, speed);
            }
        };
    })(document.getElementById("ckbox").value);

}

// change the animation when a different one is selected
function changeAnimation() {
    var newAnimation = document.getElementById("animation").value;
    var textarea = document.getElementById("mytextarea");
    textarea.value = ANIMATIONS[newAnimation];
}

// process the animation and display it
function play() {

    document.getElementById("stop").disabled = false;
    document.getElementById("start").disabled = true;
    document.getElementById("animation").disabled = true;
    var textarea = document.getElementById("mytextarea");
    var allFrames = textarea.value.split("=====\n");
    currentAnimation = allFrames;
    interval = setInterval(function () { displayNextFrame(currentAnimation); }, speed);
}

// stops the animation and displays all frames
function stop() {

    document.getElementById("start").disabled = false;
    document.getElementById("animation").disabled = false;
    changeAnimation();
    clearInterval(interval);
    document.getElementById("stop").disabled = true;
}

// a helper function that displays the next frame
function displayNextFrame(animation) {
    var textarea = document.getElementById("mytextarea");
    var currentFrame = animation.shift();
    textarea.value = currentFrame;
    animation.push(currentFrame);
    currentAnimation = animation;
}

// change the font size of the output
function changeSize() {
    var size = document.getElementById("txtsize").value;
    document.getElementById("mytextarea").style.fontSize = size;
}