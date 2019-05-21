package hdir2118MV.Repositories;

import com.sun.tools.corba.se.idl.constExpr.Not;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import hdir2118MV.Models.Nota;
import hdir2118MV.utils.ClasaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NoteRepositoryTest {

    private Nota nota1, nota2, nota3;
    private Nota nota4, nota5, nota6;
    private List<Nota> note;
    private NoteRepository repo;

    @Before
    public void setUp() throws Exception {
        nota1 = new Nota(255,"Matematica",10);
        nota2 = new Nota(255,"Mate", 10);
        nota3 = new Nota(255,"Biologie", 0);
        nota4 = new Nota(255,"Desen", 10);
        nota5 = new Nota(255,"Romana", 10);
        repo = new NoteRepository();
        System.out.println("--  Setting up for tests! -- \n");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\n-- Tearing all down! --\n");
    }

    @Test
    public void addNotaWithSucces() {
        System.out.println("Test adding new grade! - with succes\n");
        try {
            repo.addNota(nota1);
        } catch (ClasaException e) {
            e.printStackTrace();
        }
        int size = repo.getNote().size();
        assertEquals(1, size);
        assertEquals("Matematica", repo.getNote().get(size-1).getMaterie());
        System.out.println("Test passed!\n");
    }

    @Test
    public void invalidMaterie(){
        System.out.println("Test adding new grade! - Invalid materia\n");
        try {
            repo.addNota(nota2);
        } catch (ClasaException e) {
            e.printStackTrace();
            System.out.println("-- Test passed! Exception found! --\n");
        }
        int size = repo.getNote().size();
        assertEquals(0, size);
    }


    @Test
    public void invalidGrade(){
        System.out.println("Test adding new grade! - Invalid grade\n");
        try {
            repo.addNota(nota3);
        } catch (ClasaException e) {
            e.printStackTrace();
            System.out.println("-- Test passed! Exception found! --\n");
        }
        int size = repo.getNote().size();
        assertEquals(0, size);
    }

    @Test
    public void addGradesWithSucces() {
        System.out.println("Test adding new grades! - with succes\n");
        try {
            repo.addNota(nota1);
            repo.addNota(nota4);
            repo.addNota(nota5);
        } catch (ClasaException e) {
            e.printStackTrace();
        }
        int size = repo.getNote().size();
        assertEquals(3, size);
        assertEquals("Matematica", repo.getNote().get(size-3).getMaterie());
        assertEquals("Desen", repo.getNote().get(size-2).getMaterie());
        assertEquals("Romana", repo.getNote().get(size-1).getMaterie());
        System.out.println("Test passed!\n");
    }

}