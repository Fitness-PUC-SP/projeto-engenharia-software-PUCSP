package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-29T15:18:47-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 11.0.10 (AdoptOpenJDK)"
)
@Component
public class TrainerMapperImpl implements TrainerMapper {

    @Override
    public Trainer dtoToEntity(TrainerDto trainerDto) {
        if ( trainerDto == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setName( trainerDto.getName() );
        trainer.setSurname( trainerDto.getSurname() );
        trainer.setCpf( trainerDto.getCpf() );
        trainer.setEmail( trainerDto.getEmail() );
        trainer.setCellphone( trainerDto.getCellphone() );
        trainer.setWhatsapp( trainerDto.getWhatsapp() );
        trainer.setZoomAccount( trainerDto.getZoomAccount() );

        return trainer;
    }

    @Override
    public TrainerDto entityToDto(Trainer trainer) {
        if ( trainer == null ) {
            return null;
        }

        TrainerDto trainerDto = new TrainerDto();

        trainerDto.setName( trainer.getName() );
        trainerDto.setSurname( trainer.getSurname() );
        trainerDto.setCpf( trainer.getCpf() );
        trainerDto.setEmail( trainer.getEmail() );
        trainerDto.setCellphone( trainer.getCellphone() );
        trainerDto.setWhatsapp( trainer.getWhatsapp() );
        trainerDto.setZoomAccount( trainer.getZoomAccount() );

        return trainerDto;
    }

    @Override
    public Trainer requestToEntity(TrainerRequest request) {
        if ( request == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setName( request.getName() );
        trainer.setSurname( request.getSurname() );
        trainer.setCpf( request.getCpf() );
        trainer.setEmail( request.getEmail() );
        trainer.setCellphone( request.getCellphone() );
        trainer.setWhatsapp( request.getWhatsapp() );
        trainer.setZoomAccount( request.getZoomAccount() );

        return trainer;
    }
}
