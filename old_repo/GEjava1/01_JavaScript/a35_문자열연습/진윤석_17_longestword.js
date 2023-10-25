/*******************************
 * 가장 긴 단어 찾기
 */

const input = [
    "I am a Student",     // ->  Student
    "That elephant is big",  // -> elephant
]

function longestWord(str){
    let textBox = [];
    let index = 0;
    str.split(/\s+/).forEach(e => textBox.push(e));
    for(let i = 1; i < textBox.length; i++){
        (textBox[index].length < textBox[i].length) && (index = i);
    }
    return textBox[index];
};

input.forEach(e => console.log(longestWord(e)));