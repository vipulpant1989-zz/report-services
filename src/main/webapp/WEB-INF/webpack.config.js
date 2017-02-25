var config = {
   entry: [
      __dirname + '/app/scripts/app.js', 
      __dirname + '/node_modules/react-mdl/extra/material.min.css',  // <==
       __dirname + '/node_modules/react-mdl/extra/material.min.js', // <==
   ],
	
   output: {
      path: __dirname + '/build',
      filename: 'index.js',
   },
	
   devServer: {
      inline: true,
      port: 8181
   },
	
   module: {
      
      loaders: [{
           test: /\.css$/,
           loaders: [ 'css-loader' ]
         },{
            test: /\.jsx?$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
				
            query: {
               presets: ['es2015', 'react']
            }
         }
      ]
   }
}

module.exports = config;