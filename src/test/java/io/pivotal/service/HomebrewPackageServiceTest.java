package io.pivotal.service;

import com.google.common.jimfs.Jimfs;
import io.pivotal.model.HomebrewPackage;
import io.pivotal.model.Package;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HomebrewPackageServiceTest {

    private HomebrewPackageService homebrewPackageService;

    private FileSystem fileSystem;
    private GitService gitService;

    private Path localPath;
    private Path formulaPath;

    @Before
    public void before() throws Exception {
        fileSystem = Jimfs.newFileSystem(com.google.common.jimfs.Configuration.unix());
        gitService = new GitService();

        homebrewPackageService = new HomebrewPackageService(fileSystem, gitService);

        localPath = fileSystem.getPath("/tmp/localPath");
        formulaPath = localPath.resolve(fileSystem.getPath(HomebrewPackageService.REPOSITORY_NAME, "Library", "Formula"));

        Files.createDirectories(formulaPath);
        createRecipe("carrot_cake.rb", "Stir in the grated carrot.");
    }

    @Test
    public void findPackagesTest() throws IOException {
        List<Package> packages = homebrewPackageService.find(localPath);
        assertThat(packages.size()).isEqualTo(1);
        assertThat(packages.get(0).getName()).isEqualTo("carrot_cake");
        assertThat(packages.get(0).getDescription()).isEqualTo("Stir in the grated carrot.");
    }

    private void createRecipe(String name, String description) throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(formulaPath.resolve(name));
        bufferedWriter.write(String.format("desc \"%s\"", description));
        bufferedWriter.close();
    }
}