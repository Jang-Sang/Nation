/*******************************
 * 연속되지 않은 글자 출력 unique in order
 */

const input = [
    "all good tree",    // [a, l, , g, o, d, , t, r, e]
]

function uniqueInOrder(str){
    let tempArr = [];
    let result = [];
    str.split("").forEach(e => tempArr.push(e));
    for(let i = 0; i < (tempArr.length); i++){
        if(tempArr[i] != tempArr[i + 1]){
            result.push(tempArr[i]);
        }
    }
    result = `[${result.toString()}]`
    return result;
}

input.forEach(e => console.log(uniqueInOrder(e)));