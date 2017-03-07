
import React from 'react';
import {Button, Dialog , DialogTitle, DialogContent, DialogActions} from 'react-mdl';

class DialogBox extends React.Component{
 constructor(props) {
    super(props);
    this.state = {};
    this.handleOpenDialog = this.handleOpenDialog.bind(this);
    this.handleCloseDialog = this.handleCloseDialog.bind(this);
  }
  handleOpenDialog() {
    this.setState({
      openDialog: true
    });
  }
  handleCloseDialog() {
    this.setState({
      openDialog: false
    });
  }
  render() {
    return (
      <div>
        <Button colored onClick={this.handleOpenDialog} raised ripple>Create</Button>
        <Button colored onClick={this.props.resetFormHandler} raised ripple>Reset</Button>
        <Dialog open={this.state.openDialog} onCancel={this.handleCloseDialog}>
          <DialogTitle>Allow data collection?</DialogTitle>
          <DialogContent>
            <p>{this.props.text}</p>
          </DialogContent>
          <DialogActions>
            <Button type='button' onClick={this.props.submitHandler}>Agree</Button>
            <span style={{ margin : '20px'}} >
            	<Button type='button' onClick={this.handleCloseDialog}>Disagree</Button>
          	</span>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}

export default DialogBox;