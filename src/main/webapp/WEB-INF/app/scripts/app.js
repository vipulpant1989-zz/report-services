/**
 * This is the enrty file going to be used for setting up the application.
 * 
 */
'use strict';
import React from 'react';
import ReactDOM from 'react-dom';
import 'react-mdl/extra/material.min.css';
import 'react-mdl/extra/material.min.js';
import Main from './modules/main/main.jsx';
import Invoice from './modules/invoice/invoice.jsx';
import Invoices from './modules/invoice/invoices.jsx';
import { Router, Route, IndexRedirect, hashHistory} from 'react-router';

ReactDOM.render((
		<Router history={hashHistory}>
			<Route path='/' component={Main}>
				<IndexRedirect to='/invoice'/>
				<Route path='/invoice' component={Invoice}/>
				<Route path='/invoices' component={Invoices} />
			</Route>
		</Router>
	), document.getElementById('app'));
