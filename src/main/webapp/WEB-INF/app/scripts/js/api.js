import 'whatwg-fetch';

class HttpCall {

	constructor(method, data){
		this.options = {
		    method: method,
		    body: JSON.stringify(data),
		    headers: {
    			'Content-Type': 'application/json'
  			}
		};

	}
	call(url){
		return fetch(url, this.options).then(function(response){
			return response.text();
		}).catch(function(error){
			return error;
		});
	}
}


class RestService extends HttpCall{
	constructor(method, data){
		super(method, data);
	}
}

export default RestService;
export var __useDefault = true;
