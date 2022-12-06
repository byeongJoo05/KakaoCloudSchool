/*
import Iteration from './Iteration';
import ErrorBoundary from './ErrorBoundary';


import React, {Component , useState} from 'react';
import InputSample from './InputSample';

//클래스형 컴포넌트
class ClassState extends Component {
  
  // 생성자를 만들지 않고 이렇게 state를 초기화해도 됨
  state = {
    count:0
  }

  constructor(props) {
    super(props);
    this.state = {
      count:0
    }
  }

  render() {
    return (
      <div>
        <p>클릭을 {this.state.count} 번 수행</p>
        <button onClick={
          (e)=> this.setState({count: this.state.count + 1})}>
          +1
        </button>
      </div>
    );
  }
}

//함수형 컴포넌트에서 state 사용
const FunctionState = () => {
  const [count, setCount] = useState(0);
  return(
    <div>
        <p>클릭을 {count} 번 수행</p>
        <button onClick={
          (e)=> setCount(count + 1)}>
          +1
        </button>
      </div>
  )
}

function App() {
  return (
    <div>
      <ClassState />
      <FunctionState />
      <InputSample/>
    </div>
  );
}

export default App;

*/

/*
import React from 'react';

class ClassEffect extends React.Component {

  // 생성자
  constructor(props) {
    super(props);
    console.log("생성자 - 가장 먼저 호출되는 메서드");
    this.state = {
      count:0
    };
  }

  // Component 가 Mount 된 후 호출되는 메서드
  componentDidMount() {
    console.log("마운트 된 후 호출되는 메서드");
    document.title = `You clicked ${this.state.count} times`;
  }

  // Component 가 Update 된 후 호출되는 메서드
  componentDidUpdate() {
    console.log("업데이트 된 후 호출되는 메서드");
    document.title = `You clicked ${this.state.count} times`;
  }

  render() {
    return(
      <div>
        <p>You clicked {this.state.count} times</p>
        <button onClick={
          (e)=> this.setState({count:this.state.count+1})}>
            +1
          </button>
      </div>
    )
  }
}

const App = () => {
  return(
    <div>
      <ClassEffect/>
    </div>
  )
}

export default App;
*/

/*
import React, {useState, useEffect} from 'react';

const ClassEffect = () => {

  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log("마운트와 업데이트가 끝나면 호출");
    document.title = `You clicked ${count} times`;
  }, [count])

  
    return(
      <div>
        <p>You clicked {count} times</p>
        <button onClick={
          (e)=> setCount(count + 1)}>
            +1
        </button>
      </div>
    )
}


const App = () => {
  return(
    <div>
      <ClassEffect/>
    </div>
  )
}

export default App;
*/

import React from 'react';
import UserList from './UserList';
import CreateUser from './CreateUser';
import {useState, useRef} from 'react';

const App = () => {
  const [inputs, setInputs] = useState({
    username:'',
    email:''
  });
  const {username, email} = inputs;

  const onChange = (e) => {
    setInputs({
      [e.target.name]:e.target.value
    });
  } 

  const [users, setUsers] = useState ([
    {id:1, username:'adam', email:'itstudy@kakao.com'},
    {id:2, username:'son', email:'thsqudwn05@gmail.com'},
    {id:3, username:'hong', email:'honggildong@naver.com'}
  ]);

  // 변수를 생성
  const nextId = useRef(4);

  const onCreate = () => {
    const user = {
      id:nextId.current,
      username,
      email
    }

    setUsers([...users, user]);

    setInputs({
      username:'',
      email:''
    })

    nextId.current += 1;
  }

  return(
    <div>
      <CreateUser username={username} email={email}
      onChange = {onChange} onCreate={onCreate} />
      <UserList users={users}/>
    </div>
  )
}

export default App;