import React from 'react';
import { Navigation, Header, Layout , Drawer , Content} from 'react-mdl';
import { Link } from 'react-router';

class TopNav extends React.Component {
	render(){
		return(
		   <div>
		        <Header title={<span><strong>Report Engine</strong></span>}>
		            <Navigation>
		            	<Link to="/invoice" activeStyle={{ borderBottom: '5px solid #ea0707',background: '#442020'}}>Invoice</Link>
		                <Link to="/invoices" activeStyle={{ borderBottom: '5px solid #ea0707',background: '#442020'}}>Invoices</Link>
		            </Navigation>
		        </Header>
		        <Drawer title="Title">
		            <Navigation>
		                <a href="">Link</a>
		                <a href="">Link</a>
		                <a href="">Link</a>
		                <a href="">Link</a>
		            </Navigation>
		        </Drawer>
	       	</div>
		);
	}
}

export default TopNav;


