package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-23T22:16:31-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 11.0.10 (AdoptOpenJDK)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student dtoToEntity(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDto.getId() );
        student.setNickname( studentDto.getNickname() );
        student.setFullName( studentDto.getFullName() );
        student.setCpf( studentDto.getCpf() );
        student.setEmail( studentDto.getEmail() );
        student.setCellphone( studentDto.getCellphone() );
        student.setZoomAccount( studentDto.getZoomAccount() );

        return student;
    }

    @Override
    public StudentDto entityToDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        studentDto.setNickname( student.getNickname() );
        studentDto.setFullName( student.getFullName() );
        studentDto.setBirthDate( student.getBirthDate() );
        studentDto.setCpf( student.getCpf() );
        studentDto.setEmail( student.getEmail() );
        studentDto.setCellphone( student.getCellphone() );
        studentDto.setZoomAccount( student.getZoomAccount() );

        return studentDto;
    }

    @Override
    public Student requestToEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( request.getId() );
        student.setNickname( request.getNickname() );
        student.setFullName( request.getFullName() );
        student.setCpf( request.getCpf() );
        student.setEmail( request.getEmail() );
        student.setCellphone( request.getCellphone() );
        student.setZoomAccount( request.getZoomAccount() );

        return student;
    }
}
