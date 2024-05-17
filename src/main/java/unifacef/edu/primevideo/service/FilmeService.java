package unifacef.edu.primevideo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unifacef.edu.primevideo.model.dto.FilmeDTO;
import unifacef.edu.primevideo.model.entity.FilmeEntity;
import unifacef.edu.primevideo.model.repository.FilmeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    //injeção de depedencia
    @Autowired
    FilmeRepository injecao;
    public FilmeDTO insere(FilmeDTO filmeDTO){
        //convertemos FilmeDTO em FIlmeEntity para enviar ao BD
        //o metodo esta chamando sem necessidade de instanciar um objeto
        //convertemos FIlmeEntity em FilmeDTO para enviar ao front-end
        FilmeEntity resposta = injecao.save(converterDTO(filmeDTO));
        return converterEntity(resposta);
    }

    public List<FilmeDTO> consultaTodos(){
        return converterEntidade(injecao.findAll());
    }

    public FilmeDTO consultaPorId(Long id){
        Optional<FilmeEntity> optional = injecao.findById(id);
        if (optional.isPresent()){
            return converterEntity(optional.get());
        }
        else return null;
    }

    public String remove(Long id){
        if(injecao.existsById(id)){
            injecao.deleteById(id);
            return "Remoção com sucesso";
        }else{
            return "Filme não encontrado";
        }
    }

    public List<FilmeDTO> converterEntidade(List<FilmeEntity> filmesEntities){
        List<FilmeDTO> filmesDTOs = new ArrayList<FilmeDTO>();
        for (FilmeEntity filmeEntity: filmesEntities){
            filmesDTOs.add(converterEntity(filmeEntity));
        }
        return filmesDTOs;
    }
    //converter FilmeDTO em FilmeEntity
    public FilmeEntity converterDTO(FilmeDTO filmeDTO){
        return new FilmeEntity(filmeDTO.getId(), filmeDTO.getNome(), filmeDTO.getAno_lancamento(), filmeDTO.getNota());
    }

    //converter FilmeEntity em FilmeDTO
    public FilmeDTO converterEntity(FilmeEntity filmeEntity){
        return new FilmeDTO(filmeEntity.getId(), filmeEntity.getNome(), filmeEntity.getAno_lancamento(), filmeEntity.getNota());
    }
}
