<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet", href="/static/css/style.css">
    <title>Movies</title>
</head>
<body>

<div class="container">
	<a href="/movies/create" class="btn btn-success">Create new movie</a>
	<a href="/auth/login" class="btn btn-success">Login</a>
  <div class="row">
         <div class="col-12">
        		<table class="table table-image">
        		  <thead>
        		    <tr>
        		      <th scope="col">Title</th>
        		      <th scope="col">Poster</th>
        		      <th scope="col">Release year</th>
        		      <th scope="col">Director</th>
        		    </tr>
        		  </thead>
        		  <tbody>
				  <#list movies as movie>

        		    <tr>
						<td>${movie.name}</td>
        		      <td class="w-25">
        			      <img src="api/images/movies/1" class="img-fluid img-thumbnail" alt="Sheep">
        		      </td>
        		      <td>${movie.year}</td>
        		      <td>${movie.director!"-"}</td>
        		    </tr>
				  </#list>

        		  </tbody>
        		</table>
            </div>
  </div>
</div>

</body>
</html>
