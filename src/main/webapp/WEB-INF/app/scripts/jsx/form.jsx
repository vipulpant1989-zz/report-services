
import React from 'react';
import {Textfield} from 'react-mdl';


class Form extends React.Component {
	 constructor(props){
   		super(props);
   		this.getField = this.getField.bind(this);

    }
    getField(){
		return this.props.fields.map((field, index) => {
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
			<form style={{width: '300px'}} method={this.props.form.method} target={this.props.form.target} action={this.props.form.url}>
				{this.getField()}
				<span>
					<button type="submit" className ="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised mdl-button--colored">Create</button>	
				</span>
				<span style={{marginLeft: '30px'}}>
					<button type="reset" className ="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--raised mdl-button--colored">Reset</button>	
				</span>
			</form>
		);
	}
}

export default Form;