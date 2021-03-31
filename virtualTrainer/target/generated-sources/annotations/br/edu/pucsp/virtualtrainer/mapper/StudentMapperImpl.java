package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-29T15:20:28-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 11.0.10 (AdoptOpenJDK)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student dtoToEntity(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setCellphone( studentDto.getCellphone() );
        student.setCpf( studentDto.getCpf() );
        student.setEmail( studentDto.getEmail() );
        student.setName( studentDto.getName() );
        student.setSurname( studentDto.getSurname() );
        student.setWhatsapp( studentDto.getWhatsapp() );
        student.setZoomAccount( studentDto.getZoomAccount() );

        return student;
    }

    @Override
    public StudentDto entityToDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setCellphone( student.getCellphone() );
        studentDto.setCpf( student.getCpf() );
        studentDto.setEmail( student.getEmail() );
        studentDto.setName( student.getName() );
        studentDto.setSurname( student.getSurname() );
        studentDto.setWhatsapp( student.getWhatsapp() );
        studentDto.setZoomAccount( student.getZoomAccount() );

        return studentDto;
    }

    @Override
    public Student requestToEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setCellphone( request.getCellphone() );
        student.setCpf( request.getCpf() );
        student.setEmail( request.getEmail() );
        student.setName( request.getName() );
        student.setSurname( request.getSurname() );
        student.setWhatsapp( request.getWhatsapp() );
        student.setZoomAccount( request.getZoomAccount() );

        return student;
    }
}
