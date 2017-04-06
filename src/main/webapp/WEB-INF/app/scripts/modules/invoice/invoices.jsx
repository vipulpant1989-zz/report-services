import React from 'react';
import { Layout, Content, Card, CardTitle, CardText,CardActions,CardMenu} from 'react-mdl';

import CardContent from './card.content.jsx';
import Table from '../common/table.jsx';

class Invoice extends React.Component {
   constructor(){
   		super();
   		this.state = {
   			rows:[{
   				name : 'vipul',
   				lastName : 'pant',
   				dob : '16th March 1989'
   			}]
   		}
   }
   render() {
      return (
         <Content>
         	<Card shadow={1} style={{width: '100%', margin:'10px 10px 10px 10px'}}>
			    <CardTitle expand>Invoice List</CardTitle>
			    <CardText>
            		<Table rows={this.state.rows}/>
			    </CardText>
			    <CardActions>
			    </CardActions>
			    <CardMenu style={{color: '#fff'}}>
			    </CardMenu>
			</Card>
         </Content>
      );
   }
}

export default Invoice;