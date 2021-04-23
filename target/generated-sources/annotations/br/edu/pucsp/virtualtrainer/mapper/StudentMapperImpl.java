package br.edu.pucsp.virtualtrainer.mapper;

import br.edu.pucsp.virtualtrainer.model.dto.StudentDto;
import br.edu.pucsp.virtualtrainer.model.entity.Student;
import br.edu.pucsp.virtualtrainer.transport.request.StudentRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-22T01:25:30-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 15 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student dtoToEntity(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setNickname( studentDto.getNickname() );
        student.setFullName( studentDto.getFullName() );
        student.setBirthdate( studentDto.getBirthdate() );
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

        studentDto.setBirthdate( student.getBirthdate() );
        studentDto.setCellphone( student.getCellphone() );
        studentDto.setCpf( student.getCpf() );
        studentDto.setEmail( student.getEmail() );
        studentDto.setFullName( student.getFullName() );
        studentDto.setNickname( student.getNickname() );
        studentDto.setZoomAccount( student.getZoomAccount() );

        return studentDto;
    }

    @Override
    public Student requestToEntity(StudentRequest request) {
        if ( request == null ) {
            return null;
        }

        Student student = new Student();

        student.setNickname( request.getNickname() );
        student.setFullName( request.getFullName() );
        student.setBirthdate( request.getBirthdate() );
        student.setCpf( request.getCpf() );
        student.setEmail( request.getEmail() );
        student.setCellphone( request.getCellphone() );
        student.setZoomAccount( request.getZoomAccount() );

        return student;
    }
}
