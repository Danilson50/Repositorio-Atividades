import React, { Component } from 'react';

import filmeService from '../../services/filmeService';

export default class filmeAdd extends Component {

  constructor(props) {
    super(props);

    this.setTitulo = this.setTitulo.bind(this);
    this.setSinopse = this.setSinopse.bind(this);
    this.setLancamento = this.setLancamento.bind(this);
    this.setProdutores = this.setProdutores.bind(this);
    this.setArtistas = this.setArtistas.bind(this);
    this.novo = this.novo.bind(this);
    this.salva = this.salva.bind(this);

    this.state = {
      id: null,
      titulo: '',
      sinopse: '',
      lancamento: '',
      produtores: '',
      artistas: '',
      submitted: false
    };
  }

  setTitulo(e) {
    this.setState({ titulo: e.target.value });
  }

  setSinopse(e) {
    this.setState({ sinopse: e.target.value });
  }

  setLancamento(e) {
    this.setState({ lancamento: e.target.value });
  }

  setProdutores(e) {
    this.setState({ produtores: e.target.value });
  }

  setArtistas(e) {
    this.setState({ artistas: e.target.value });
  }

  novo() {
    this.setState({
      id: null,
      titulo: '',
      sinopse: '',
      lancamento: '',
      produtores: '',
      artistas: '',
      submitted: false      
    });
  }

  salva() {
    let data = {
      titulo: this.state.titulo,
      sinopse: this.state.sinopse,
      lancamento: this.state.lancamento,
      produtores: this.state.produtores,
      artistas: this.state.artistas
    };

    FilmeService.create(data)
      .then(res => this.setState({
        id: res.id,
        titulo: res.titulo,
        sinopse: res.sinopse,
        lancamento: res.lancamento,
        produtores: res.produtores,
        artistas: res.artistas,
        submitted: true
      }))
      .catch(err => console.log); 
  }

  render() {
    return (
      <div className="submit-form">
        { this.state.submitted ? (
          <div>
            <h4>Filme salvo</h4>
            <button className="btn btn-success" onClick={this.novo}>Novo</button>
          </div>
          ) : (
            <div>
              <div className="form-group">
                <label htmlFor="titulo">Titulo</label>
                <input type="text" className="form-control" id="titulo" required 
                  value={this.state.titulo} onChange={this.setTitulo} name="titulo" />
              </div>
              <div className="form-group">
                <label htmlFor="sinopse">Sinopse</label>
                <input type="text" className="form-control" id="sinopse" required
                  value={this.state.sinopse} onChange={this.setSinopse} name="sinopse" />
              </div>
              <div className="form-group">
                <label htmlFor="lancamento">Ano de Lancamento</label>
                <input type="text" className="form-control" id="anoLancamento" required
                  value={this.state.lancamento} onChange={this.setlancamento} name="lancamento" />
              </div>
              <div className="form-group">
                <label htmlFor="produtores">Produtores</label>
                <input type="text" className="form-control" id="produtores" required
                  value={this.state.produtores} onChange={this.setProdutores} name="produtores" />
              </div>
              <div className="form-group">
                <label htmlFor="artistas">Artistas</label>
                <input type="text" className="form-control" id="artistas" required
                  value={this.state.artistas} onChange={this.setartistas} name="artistas" />
              </div>                            
              <button onClick={this.salva} className="btn btn-success">Salvar</button>
            </div>
          )
        } 
      </div>
    );
  }

}