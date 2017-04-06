import React from 'react';
import TopNav from './header.nav.jsx';
import { Layout,Content} from 'react-mdl';

class Main extends React.Component {
   constructor(){
   		super();
   }
   render() {
      return (
         <div>
            <Layout fixedHeader>
            	<TopNav></TopNav>
               {this.props.children}
            </Layout>   
         </div>
      );
   }
}

export default Main;