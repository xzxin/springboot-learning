import React, { Component } from 'react';
import axios from 'axios'
import './App.css'

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id:'',
            name:'',
            password:'',
            list:[]
        }
    }

    render() {
        return (
            <div className="container-fluid" style={{marginTop: '20px'}}>
                <div className="row">
                    <div className="col-xs-4 col-xs-offset-1">
                        <table className="table table-bordered">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>用户名</th>
                                <th>密码</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.list.map(item=>{
                                    return (
                                        <tr key={item.id}>
                                            <td>{item.id}</td>
                                            <td>{item.name}</td>
                                            <td>{item.password}</td>
                                            <td>
                                                <button className="btn btn-primary" onClick={()=>{this.setState({id:item.id,name:item.name})}}>修改</button>
                                                <button className="btn btn-danger" style={{marginLeft:'5px'}} onClick={()=>{this.deleteItem(item)}}>删除</button>
                                            </td>
                                        </tr>
                                    )
                                })
                            }
                            </tbody>
                        </table>
                    </div>
                    <div className="col-xs-3 col-xs-offset-1">
                        <form className="form-horizontal">
                            <div className="form-group">
                                <label htmlFor="name" className="col-xs-3">用户名</label>
                                <div className="col-xs-8">
                                    <input type="text" id="name" className="form-control" value={this.state.name} onChange={(e)=>{this.setState({name:e.target.value})}}/>
                                </div>
                                <label htmlFor="name" className="col-xs-3">密码</label>
                                <div className="col-xs-8">
                                    <input type="text" id="password" className="form-control" value={this.state.password} onChange={(e)=>{this.setState({password:e.target.value})}}/>
                                </div>

                            </div>
                            <div className="form-group">
                                <div className="col-sm-offset-2 col-sm-10">
                                    <button className="btn btn-default" onClick={this.handleFormSubmit}>提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
    componentDidMount(){
        this.query();
    }

    query = () => {
        axios.get('/user/queryAll').then(({data})=>{
            console.log(data);
            console.log(data["data"]);
            this.setState({
                list:data["data"]
            });
        })
    };

    deleteItem = (item) => {
        console.log(Number(item["id"]));
        axios.delete(`/user/delete/${item.id}`).then(({data})=>{
            console.log(data);
            this.query();
        })
    };

    handleFormSubmit = (e) => {
        e.preventDefault();
        let isUpdate = false;
        if(this.state.name !== ''){
            this.state.list.map((item => {
                if (this.state.id === item.id) {
                    isUpdate = true;
                }
                return true;
            }));
            console.log(this.state);
            if (isUpdate) {
                axios.put('/user/update', {
                    "id": this.state.id,
                    "name": this.state.name,
                    "password": this.state.password
                }).then(({data}) => {
                    this.setState({
                        id: '',
                        name: '',
                        password: ''
                    });
                    this.query();
                })
            } else {
                axios.post('/user/insert', {
                    "id": null,
                    "name": this.state.name,
                    "password": this.state.password
                }).then(({data}) => {
                    this.setState({
                        id: '',
                        name: '',
                        password: ''
                    });
                    this.query();
                })
            }

        }
    }

}
export default App;