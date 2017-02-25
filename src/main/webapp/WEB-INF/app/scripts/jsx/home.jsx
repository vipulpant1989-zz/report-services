import React from 'react';
import TopNav from './header.nav.jsx';
import { Layout, Content} from 'react-mdl';

import CardContent from './card.content.jsx';

class App extends React.Component {
   constructor(){
   		super();
   		this.state = {
   			data : [],
   			formData : {},
   			fields : [{
   				name : 'companyName',
   				label: 'Company Name',
   				type : 'text'
   			},{
   				name : 'amount',
   				label: 'Amount',
   				type : 'number'
   			},{
   				name : 'artistName',
   				label: 'Artist Name',
   				type : 'text'
   			},{
   				name : 'address',
   				label: 'Address',
   				type : 'textArea'
   			},{
   				name : 'subject',
   				label: 'Subject',
   				type : 'textArea'
   			}]
   		}
   		this.setStateHandler = this.setStateHandler.bind(this);
   		this.updateFormData  = this.updateFormData.bind(this);
   }
   setStateHandler(){
   		let array = [];
   }
   updateFormData(event){
   		let formData = this.state.formData;
   		formData[event.target.name] = event.target.value;
   		this.setState({formData : formData});
   }
   render() {
      return (
         <div>
         	<Layout fixedHeader>
                <TopNav></TopNav>
                <Content>
                	<CardContent fields={this.state.fields} formData={this.state.formData} updateFormData={this.updateFormData}>
                	</CardContent>
                </Content>
            </Layout>
         </div>
      );
   }
}

export default App;