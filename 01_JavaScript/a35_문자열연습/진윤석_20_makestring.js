/*******************************
 * 단어의 앞글자로만 만들어진 문자열 생성
 */

const input = [
    "The community at Code States might be the biggest asset", // -> TcaCSmbtba
    "i am a PROGRAMMER",     // -> iaaP
    "THAT ELEPHANT IS BIG",  // -> TEIB
]

function makeString(str){
    let first = [];
    str.split(/\s+/).forEach(e => first.push(e[0]));

    return first.join("");
}

input.forEach(e => console.log(makeString(e)));