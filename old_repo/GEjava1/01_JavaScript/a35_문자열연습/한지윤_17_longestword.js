/*******************************
 * 가장 긴 단어 찾기
 */

const input = [
    "I am a Student", // ->  Student
    "That elephant is big", // -> elephant
]

function longestWord(str) {
    let split = str.split(" ");
    const result = split.sort((a, b) => {
        return a.length - b.length
    });
    const longest = result.pop();
    return longest;

}


input.forEach(e => console.log(longestWord(e)));


/**
 *  
 * 1. split
 * 2. compare String length
 */