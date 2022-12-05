/*
import React, {Component} from 'react';

class StateComponent extends Component {
    state = {number:0};
    
    // constructor(props) {
    //     // 상위 클래스의 생성자 호출
    //     super(props);
    //     //state 생성
    //     this.state = {number:0}
    }
    

    render() {
        return (
            <>
                <p>숫자:{this.state.number}</p> //로컬 데이터를 넣고
                <button onClick={(e) => { //서버에 데이터를 넣는 식으로 하는 방식으로 하면 좋을듯
                    this.setState(
                        {number:this.state.number+1},
                        () => {
                            console.log('state 의 값이 변경됨');
                            console.log(this.state);
                        }
                    )
                }}>증가</button>
            </>
        )
    }
};

export default StateComponent;
*/

import React, {useState} from 'react';

const StateComponent = () => {
    // 함수형 컴포넌트에서 state를 생성하는 방법
    const [message, setMessage] = useState('');

    // 버튼에 연결한 이벤트 처리 함수
    const onClickEnter = (e) => {setMessage('안녕하세요.')}
    const onClickLeave = (e) => {setMessage('안녕히 가세요.')}

    const [color, setColor] = useState('black');

    return(
        <>
            <button onClick={onClickEnter}>입장</button>
            <button onClick={onClickLeave}>퇴장</button>
            <h1 style={{color}}>{message}</h1>
            <button style={{color:'red'}} onClick={()=>setColor('red')}>빨강</button>
            <button style={{color:'green'}} onClick={()=>setColor('green')}>초록</button>
            <button style={{color:'blue'}} onClick={()=>setColor('blue')}>파랑</button>            
        </>
    )
};

export default StateComponent;