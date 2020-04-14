package implement.servlet;
import implement.model.Livro;
import implement.util.hibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/biblioteca")
public class livroServlet extends HttpServlet {
    private EntityManager entityManager;

    @Override
    public void init(){
        entityManager = new hibernateUtil.INSTANCE.getEntityManagerFactory().createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{
        String forward = "";
        String action = requisicao.getParameter("action");
        String livroId = requisicao.getParameter("livroId");

        if("remove".equals(action) && (livroId != null && !livroId.equals(""))){
            Long id = Long.parseLong(livroId);
            this.delete(id);
            requisicao.setAttribute("livros",this.lista());
            forward = "/livro.jsp";

        }else if("edita".equals(action) && (livroId != null && !livroId.equals(""))){
            Long id = Long.parseLong(livroId);
            Livro livro = entityManager.find(Livro.class, id);

            requisicao.setAttribute("livro", livro);
            forward = "/form.jsp";

        }else if("inclui".equals(action)){
            forward = "/form.jsp";

        }else{
            requisicao.setAttribute("livros",this.lista());
            forward = "/livro.jsp";
        }

        RequestDispatcher rd = requisicao.getRequestDispatcher(forward);
        rd.forward(requisicao,resposta);
    }
    @Override
    protected void doPost(HttpServletRequest requisicao, HttpServletResponse resposta) throws ServletException, IOException{

        String livroId = requisicao.getParameter("id");
        Livro livro = null;

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            if(livroId != null && !"".equals(livroId)){
                Long id = Long.parseLong(livroId);

                livro = entityManager.find(Livro.class, id);
                livro.setTitulo(requisicao.getParameter("titulo"));
                livro.setAutor(requisicao.getParameter("autor"));
                livro.setResumo(requisicao.getParameter("resumo"));
                livro.setAnoLancamento(requisicao.getParameter("anoLancamento"));

            }else{
                livro = new Livro();
                livro.setTitulo(requisicao.getParameter("titulo"));
                livro.setAutor(requisicao.getParameter("autor"));
                livro.setResumo(requisicao.getParameter("resumo"));
                livro.setAnoLancamento(requisicao.getParameter("anoLancamento"));
            }
            entityManager.persist(livro);
            entityManager.flush();
            transaction.commit();
        }catch(Exception e){
            if (transaction.isActive()){
                transaction.rollback();
            }
            throw new RuntimeException("Não foi possível salvar o livro: "+ e.getMessage());
        }
        requisicao.setAttribute("livros",this.lista());
        RequestDispatcher rd = requisicao.getRequestDispatcher("/livro.jsp");
        rd.forward(requisicao,resposta);
    }

    private List<Livro> lista(){
        return entityManager
                .createQuery("select l from Livro l", Livro.class)
                .getResultList();
    }

    private void delete(Long livroId){
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Livro livro = entityManager.find(Livro.class, livroId);
            entityManager.remove(livro);
            entityManager.flush();

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Não foi possível deletar o livro: "+ e.getMessage());
        }
    }
    @Override
    public void destroy() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
