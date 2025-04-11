<#import '../layout.ftlh' as main>

<@main.layout>
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
</@main.layout>

