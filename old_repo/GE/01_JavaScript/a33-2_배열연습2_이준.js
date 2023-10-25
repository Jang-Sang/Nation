// 퀴즈1
// 주어진 배열에서 3보타 큰 숫자로 구성된 배열구하기
{
    function biggerThanThree(numbers) {
       let A = [];
       A = numbers.filter(e => e > 3)
       return A;
    }
    
    const numbers = [1, 2, 3, 4, 5, 6, 7];
    console.log(biggerThanThree(numbers)); // [4, 5, 6, 7]
}
  
// 퀴즈2
// 주어진 배열의 원소를 x3 한 배열 구하기
{
    function multiple3(numbers) {
        let A = [];
        A = numbers.map(n => n * 3)
        return A;
    }
    
    const numbers = [1, 2, 3, 4, 5];
    console.log(multiple3(numbers)); // [3, 6, 9, 12, 15]
}  
  

// 퀴즈3
// 성이 '김' 씨인 사람만 담긴 배열 구하기
{
    const students = [
        {name: '김철수', score: [10, 20, 30]},
        {name: '박수진', score: [90, 33, 56]},
        {name: '김영희', score: [45, 78, 31]},
        {name: '조수현', score: [99, 100, 67]},
    ]

    function filterStu(data, start){
            let A = [];
            A = data.filter(e => e.name.charAt(0) === start)
            return A;
    }
    console.log(filterStu(students, '김'));
    // 결과]
    // [
    //     { name: '김철수', score: [ 10, 20, 30 ] },
    //     { name: '김영희', score: [ 45, 78, 31 ] }
    // ]
}

// 퀴즈4
// 총점을 담을 배열 구하기
{
    const students = [
        {name: '김철수', score: [10, 20, 30]},
        {name: '박수진', score: [90, 33, 56]},
        {name: '김영희', score: [45, 78, 31]},
        {name: '조수현', score: [99, 100, 67]},
    ]

    function getTotal(data){
        let A = [];
        let B = [];
        let C = [];
        C = data.map(e => e.name)
        A = data.map(e => e.score)

        let result = [];
        for(let i = 0; i < A.length; i++) {
            B = A[i].reduce((a, b) => a + b);
            //console.log(`name: '${C[i]}', total: ${B}`);
            result.push({name: C[i], total: B});
        }
        return result;
    }
    console.log(getTotal(students));

    // 결과]
    // [
    //     { name: '김철수', total: 60 },      
    //     { name: '박수진', total: 179 },     
    //     { name: '김영희', total: 154 },     
    //     { name: '조수현', total: 266 }      
    // ]    
}
// sum = numbers.reduce((accumulator, current) => accumulator + current);
// console.log('sum =', sum);
