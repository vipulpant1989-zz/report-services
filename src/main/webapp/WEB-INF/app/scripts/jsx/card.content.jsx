'use strict';
import React from 'react';
import {Card,CardTitle,CardText,CardActions,CardMenu,IconButton,Button} from 'react-mdl';
import DialogBox from './dialog.box.jsx';
import Form from './form.jsx';
import RestService from '../js/api.js';

class CardContent extends React.Component{
	constructor(props){
   		super(props);
   		this.onClickDialogHandler = this.generateReport.bind(this);
   		this.resetFormHandler = this.resetForm.bind(this);
   		this.state = {
   			message : 'Are you sure? You want to generate a report!'
   		}
    }
   	generateReport(){
   		let formData = this.props.formData;
   		const url = '/reports?format=pdf';
   		var restService = new RestService('POST', formData);
        restService.call(url).then(function(data){
        	var popup = window.open("", "report", "width=1000,height=1000");
        	popup.document.write(data);
        });
    }
    resetForm(){
    	let formData = this.props.formData;
    	console.log(formData);
    	formData = {};
   		super.setState({formData : formData});
   	}
	render(){
		return(
			<Card shadow={1} style={{width: '500px', height: '700px', margin: 'auto'}}>
			    <CardTitle expand style={{color: '#fff', background: 'url(http://www.getmdl.io/assets/demos/dog.png) bottom right 15% no-repeat #46B6AC'}}>Create Invoice</CardTitle>
			    <CardText>
                	<Form fields={this.props.fields} form = {this.props.form} formData={this.props.formData} updateFormData={this.props.updateFormData}>
                	</Form>
			    </CardText>
			    <CardActions>
			    </CardActions>
			    <CardMenu style={{color: '#fff'}}>
			        <IconButton name="share" />
			    </CardMenu>
			</Card>
		);
	}
}
 
export default CardContent;