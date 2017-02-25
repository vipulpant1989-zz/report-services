
import React from 'react';
import {Textfield} from 'react-mdl';


class Form extends React.Component {
	 constructor(props){
   		super(props);
   		this.getField = this.getField.bind(this);
    }
    getField(){
		return this.props.fields.map((field , index) => {
			if(field.type === 'textArea'){
			   return <span key={index.toString()}><Textfield rows={3} floatingLabel label = {field.label} name ={field.name} onChange={this.props.updateFormData}/></span>;
			}else if(field.type === 'number'){
				return <span key={index.toString()}><Textfield pattern="-?[0-9]*(\.[0-9]+)?" error="Not a valid number." floatingLabel label = {field.label} name ={field.name} onChange={this.props.updateFormData}/></span>;
			}
			return <span key={index.toString()}><Textfield floatingLabel label = {field.label} name ={field.name} onChange={this.props.updateFormData}/></span>;
		});
    }
    render(){
		return (
			<div style={{width: '300px'}}>
				{this.getField()}		
			</div>
		);
	}
}

export default Form;