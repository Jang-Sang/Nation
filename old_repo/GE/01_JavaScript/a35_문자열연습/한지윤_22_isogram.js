/*******************************
 * isogram : 중복글자 없는 단어
 * isogram 여부 판단하기 (true/false)
 */

const input = [
    "Dermatoglyphics", // -> true
    "programmer",      // -> false
    "Correct",         // -> false
    "isogram",         // -> true
]

function isIsogram(str){
    
    for(let i = 0; i<str.length - 1; i++){
        for(let j = i + 1; j < str.length; j++){
            if(str[i].toLowerCase() ==  str[j].toLowerCase()){
                return false;
            }
        }
    }
    return true;
}

input.forEach(e => console.log(isIsogram(e)));


   



/*
 * 
 * 같은 문자가 나오면 false, 같은 문자가 없다면 true
 */