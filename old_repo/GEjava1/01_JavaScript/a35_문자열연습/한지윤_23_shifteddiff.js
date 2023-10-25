/*******************************
 * 문자열 시프팅 차이값
 */

const input = [
// [first, second]
    ["hello", "hello"],    // 0
    ["hello", "ohell"],    // 1
    ["hello", "lohel"],    // 2
    ["hello", "llohe"],    // 3
    ["hello", "elloh"],    // 4
    ["hello", "elohl"],    // -1

]


function shiftedDiff(first, second){
    first_arr = first.split("");
    for (i=0; i<first.length; i++) {
        
        if (first_arr.join("") == second) {
            return i;
        }
        first_arr.unshift(first_arr.pop());
        
    }
    return -1;
}

input.forEach(e => console.log(shiftedDiff(e[0], e[1])));

/*
    1.

 */