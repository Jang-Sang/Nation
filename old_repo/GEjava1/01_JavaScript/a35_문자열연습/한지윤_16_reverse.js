/*******************************
 * 문자열 좌우 반전
 */

const input = [
    "abcde",            // edcba
    "I am a Student",   // tnedutS a ma I
]

function reverse(str){

    return str.split("").reverse().join("");
    
}



input.forEach(e => console.log(reverse(e)));

/**
 * 1. split
 * 2. reverse
 * 3. join
 * 
 *     
    let split = str.split("");
    let reverse = split.reverse();
    let join = reverse.join("");
 */
