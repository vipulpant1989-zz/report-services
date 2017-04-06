import React from 'react';
import {DataTable,TableHeader} from 'react-mdl';


class Table extends React.Component{
	constructor(props){
		super(props);
		this.state ={};
		this.loadRows = this.loadHeaders.bind(this);
	}
	loadHeaders(){
		const row  = this.props.rows[0];
		const keys = Object.keys(row);
		return keys.map((key, index) => {
			if(row.hasOwnProperty(key)){
				return <TableHeader
			        	name={key}
			        	sortFn={(a, b, isAsc) => (isAsc ? a : b).match(/\((.*)\)/)[1].localeCompare((isAsc ? b : a).match(/\((.*)\)/)[1])}
			        	>{key.toUpperCase()}</TableHeader>
			}
		});
	}
	render(){
		return(
			<div>
				<DataTable 
					style={{width:'100%'}}
				    sortable
				    shadow={0}
				    rows={this.props.rows}
					>
				    {this.loadHeaders()}
				</DataTable>
			</div>
		);
	}
}
export default Table;