package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.TrainerDto;
import br.edu.pucsp.virtualtrainer.model.entity.Trainer;
import br.edu.pucsp.virtualtrainer.transport.request.TrainerRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-15T01:32:34-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
public class TrainerMapperImpl implements TrainerMapper {

    @Override
    public Trainer dtoToEntity(TrainerDto trainerDto) {
        if ( trainerDto == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setNickname( trainerDto.getNickname() );
        trainer.setFullName( trainerDto.getFullName() );
        trainer.setCpf( trainerDto.getCpf() );
        trainer.setCnpj( trainerDto.getCnpj() );
        trainer.setEmail( trainerDto.getEmail() );
        trainer.setCellphone( trainerDto.getCellphone() );
        trainer.setZoomAccount( trainerDto.getZoomAccount() );
        trainer.setActive( trainerDto.isActive() );

        return trainer;
    }

    @Override
    public TrainerDto entityToDto(Trainer trainer) {
        if ( trainer == null ) {
            return null;
        }

        TrainerDto trainerDto = new TrainerDto();

        trainerDto.setNickname( trainer.getNickname() );
        trainerDto.setFullName( trainer.getFullName() );
        trainerDto.setCnpj( trainer.getCnpj() );
        trainerDto.setCpf( trainer.getCpf() );
        trainerDto.setEmail( trainer.getEmail() );
        trainerDto.setCellphone( trainer.getCellphone() );
        trainerDto.setZoomAccount( trainer.getZoomAccount() );
        trainerDto.setActive( trainer.isActive() );

        return trainerDto;
    }

    @Override
    public Trainer requestToEntity(TrainerRequest request) {
        if ( request == null ) {
            return null;
        }

        Trainer trainer = new Trainer();

        trainer.setNickname( request.getNickname() );
        trainer.setFullName( request.getFullName() );
        trainer.setBirthdate( request.getBirthdate() );
        trainer.setCpf( request.getCpf() );
        trainer.setCnpj( request.getCnpj() );
        trainer.setEmail( request.getEmail() );
        trainer.setCellphone( request.getCellphone() );
        trainer.setZoomAccount( request.getZoomAccount() );

        return trainer;
    }
}
