<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <title>Document</title>
</head>
<body>
    <div class="container">
        <form action="/movies/create" method="post">
            <input type="text" name="name" class="form-control" placeholder="Title">
            <input type="number" name="releaseYear" class="form-control" placeholder="Release year">
            <div class="md-3">
                <label for="desc" class="form-label">Description</label>
                <textarea name="description" id="desc" rows="3" class="form-control"></textarea>
            </div>
            <input type="text" name="director" class="form-control" placeholder="Director">
            <input type="text" name="castMemberRole" class="form-control" placeholder="Cast Member Role">
            <input type="text" name="castMemberName" class="form-control" placeholder="Cast Member Name">

            <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
</body>
</html>