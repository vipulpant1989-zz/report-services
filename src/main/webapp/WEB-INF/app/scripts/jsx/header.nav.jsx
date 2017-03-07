import React from 'react';
import { Navigation, Header, Layout , Drawer , Content} from 'react-mdl';

class TopNav extends React.Component {
	render(){
		return(
		   <div>
		        <Header title={<span><span style={{ color: '#ddd' }}>Area / </span><strong>Report Engine</strong></span>}>
		            <Navigation>
		                <a href="">Link</a>
		                <a href="">Link</a>
		                <a href="">Link</a>
		                <a href="">Link</a>
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


