import React from 'react';

class avaliacaoList extends React.Component {

  setRow(avaliacao, index) {
    return (
      <tr key={index}>
        <td>{avaliacao.usuario}</td>
        <td>{avaliacao.comentario}</td>
        <td>{avaliacao.voto}</td>
      </tr>
    );
  }

  setFooter(avaliacoes) {
    const total = avaliacoes.map(a => +a.nota).reduce((acc, curr) => acc + curr, 0); 
    const media = (total / avaliacoes.length) || 0;
   
    return (
      <tr>
        <td colSpan="2">Média dos Votos</td>
        <td>{media}</td>
      </tr>
    );
  }

  setTable(avaliacoes) {
    return (
      <table className="table table-striped table-sm">
        <thead className="thead-dark">
          <tr>
            <th>Usuário</th>
            <th>Comentário</th>
            <th>Voto</th>
          </tr>
        </thead>
        <tbody>
          { avaliacoes.map((avaliacao, index) => this.setRow(avaliacao, index)) }
        </tbody>
        <tfoot>
          { this.setFooter(avaliacoes) }
        </tfoot>
      </table>
    );
  }

  render() {
    const { avaliacoes } = this.props;

    return (
      <div>
        <br />
       { this.setTable(avaliacoes) }
      </div>
    );
  }

}

export default avaliacaoList;