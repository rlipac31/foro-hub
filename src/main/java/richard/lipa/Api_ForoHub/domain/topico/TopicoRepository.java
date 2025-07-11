package richard.lipa.Api_ForoHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByStateTrue(Pageable paginacion);

}
