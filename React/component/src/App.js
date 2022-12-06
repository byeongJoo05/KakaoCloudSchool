import StateComponent from './StateComponent';
import MyComponent from './MyComponent';
import EventPractice from './EventPractice';
import ValidationSample from './ValidationSample';
import ScrollBox from './ScrollBox';
import React,{Component} from 'react';

class App extends Component {
  render() {
    return (
      <div>
      <MyComponent name= {3}>태그 안의 내용</MyComponent>
      <StateComponent/>
      <EventPractice/>
      <ValidationSample/>
      <ScrollBox ref = {ref => {this.box = ref;}}/>
      <button onClick={(e)=>{this.box.scrollToBottom()}}>
        맨아래로
      </button>
      </div>
    );
  }
}

export default App;

