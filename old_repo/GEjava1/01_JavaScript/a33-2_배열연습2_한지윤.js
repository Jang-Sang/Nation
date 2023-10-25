// 퀴즈1
console.log('퀴즈1','-'.repeat(30))
// 주어진 배열에서 3보다 큰 숫자로 구성된 배열구하기
{
    function biggerThanThree(numbers) {
        arr = [];
        numbers.forEach(e => {e > 3 && arr.push(e)})
        return arr;
        
    }
    
    const numbers = [1, 2, 3, 4, 5, 6, 7];
    console.log(biggerThanThree(numbers)); // [4, 5, 6, 7]
}  

// 퀴즈2
console.log('퀴즈2','-'.repeat(30))
// 주어진 배열의 원소를 x3 한 배열 구하기
{
    function multiple3(numbers) {
        result = numbers.reduce((acc, cur) =>{
            acc.push(cur * 3);
            return acc;
        },[]);
        return result;
    }
    
    const numbers = [1, 2, 3, 4, 5];
    console.log(multiple3(numbers)); // [3, 6, 9, 12, 15]
}  


// 퀴즈3
console.log('퀴즈3','-'.repeat(30))
// 성이 '김' 씨인 사람만 담긴 배열 구하기
{
    const students = [
        {name: '김철수', score: [10, 20, 30]},
        {name: '박수진', score: [90, 33, 56]},
        {name: '김영희', score: [45, 78, 31]},
        {name: '조수현', score: [99, 100, 67]},
    ]

    function filterStu(data, start){
        return data.filter(e => e.name.startsWith(start));
    }
    console.log(filterStu(students, '김'));
    // 결과]
    // [
    //     { name: '김철수', score: [ 10, 20, 30 ] },
    //     { name: '김영희', score: [ 45, 78, 31 ] }
    // ]
}

// 퀴즈4
console.log('퀴즈4','-'.repeat(30))
// 총점을 담을 배열 구하기
{
    const students = [
        {name: '김철수', score: [10, 20, 30]},
        {name: '박수진', score: [90, 33, 56]},
        {name: '김영희', score: [45, 78, 31]},
        {name: '조수현', score: [99, 100, 67]},
    ]

    function getTotal(data){
        let results = []
        for (student of students) {
            let total = student["score"].reduce((prvSum, e) => prvSum + e, 0);
            results.push(
                {name: student["name"], total: total}
            );
        }
        return results;
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