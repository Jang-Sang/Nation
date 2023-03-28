// 퀴즈1
// 주어진 배열에서 3보타 큰 숫자로 구성된 배열구하기
{
    const numbers = [1, 2, 3, 4, 5, 6, 7];
    // refuce
    function biggerThanThree(numbers) {
        
        result = numbers.reduce((acc, cur) => {
            if(cur > 3){
                acc.push(cur);
            }
           
            return acc;

        }, []) ;
        
        return result;
    }
    
    
    console.log(biggerThanThree(numbers)); // [4, 5, 6, 7]
}  
  
// 퀴즈2
// 주어진 배열의 원소를 x3 한 배열 구하기
{

    const numbers = [1, 2, 3, 4, 5];

    function multiple3(numbers) {
        result = [];
        result = numbers.reduce((acc, cur) => {
            acc.push(cur * 3);
            return acc;
        }, []);

        return result;
    }
    
    
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
        let n = [];
        data.forEach(e => {
            
            if(e.name.split('')[0] === start){
                
                if(n[0] == undefined){
                    n[0] = e;
                } else if(n[0] != undefined){
                    n[1] = e;
                }
            }
             
           
       });
       return n;
       
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
        let total = 0;
        let num = [];
        let count = 0;
        data.forEach(e => {
            e.score.forEach(r => {
                total += r;
                
            });

            delete e.score;
            e["total"] = total;
            
            num[count] = e;
            count++;
            
            
            
        })
        return num;
        
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